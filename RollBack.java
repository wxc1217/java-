import java.io.FileOutputStream;
import java.io.FileinputStream;
import java.lang.*;

public class RollBack{
    private String rootTreeKey;
    private final String rollBackPath;

    //�޲ι��췽��,�ع�·������Ĭ��ΪHash���ṩ��Ĭ�Ϲ���·����
    public RollBack(){
        rollBackPath=Hash.objectpath;
    }

    //�Ը���commit key����������·��Ϊ�����Ĺ��췽��
    public RollBack(String givenCommitKey,String givenPath)throws Exception{
        
        //���ݸ���·�������ɻع��ֿⴢ��·����
        rollBackPath=givenPath + "\\.RollBackRepository";
        
        //�������ļ���·�����Ƿ����У�����ɾ����
        File[] folder = new File(givenPath).listFiles();
        for (File f: folder){
            if (!f.getName().equals(".RollBackRepository"))
                deleteFolder(f);
        }
        
        //���ݸ���commit key����Commit����ʹ�÷������õ���Ŀ¼tree��key��
        Commit rollBackCommit=new Commit(givenCommitKey);
        rootTreeKey=rollBackCommit.getRootTreeKey();

        //������Ŀ¼Tree��Key�����ݸ�tree������������ļ����ڵ����ļ������ļ��������Լ���Ӧ��blob/tree key���лָ�;
        recoverRollBack(rootTreeKey,rollBackPath);

        //����HEADָ��;
        rollBackCommit.updateHEAD(rootTreeKey);
    }


    //��tree������������ļ����ڵ����ļ������ļ��������Լ���Ӧ��blob/tree key���лָ�;
    private void recoverRollBack(String rootTreeKey, String rollBackPath) throws Exception{
        String rootTreeKeyPath = rollBackPath +"\\"+ rootTreeKey;
        File treeNode = new File(rootTreeKeyPath);
        InputStreamReader isr = new InputStreamReader(new FileInputStream(treeNode));
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while(line != null){
            String[] list = line.split(" ");
            if(list[0].equals("Blob")){
                FileInputStream is = new FileInputStream(filePath+"\\"+list[1]);
                FileOutputStream os = new FileOutputStream(rollBackPath+"\\"+list[2]);
                byte[] buffer = new byte[1024];
                int numRead = 0;
                while (numRead != -1) {
                    numRead = is.read(buffer);
                    if (numRead > 0)
                        os.write(buffer, 0, numRead);
                }
                is.close();
                os.close();
            }
            else if(list[0].equals("Tree")){
                File f = new File(rollBackPath + "\\" + list[2]);
                if (!f.exists())
                    f.mkdir();
                // �ݹ�dfs
                recoverRollBack(list[1], rollBackPath + "\\" + list[2]);  
            }
            line = br.readLine();
        }
    }

        //������е��ļ��еķ���
        private void deleteFolder(File f) throws Exception {
            if (!f.exists()) {
                throw new Exception("No folder!");
            }
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        deleteFolder(file);
                    } else {
                        file.delete();
                    }
                }
            }
            f.delete();
        }
    
        //չʾ��ǰ��ʷCommit����־�����ڻع�ǰ��ѯ
        public void printCommitLog()throws IOException{
            Commit temp=new Commit();
            String presentCommit=temp.readHEAD();//��HEAD�ļ��ж�ȡ��ǰCommit��key
            Commit pCommit=new Commit(presentCommit);

            System.out.println(pCommit.getKey());
            System.out.println(pCommit.getValue());

            String previousCommit = pCommit.getPreviousCommit();

            while(previousCommit != null){ //�ݹ����

                Commit cCommit = new Commit(previousCommit);

                System.out.println(cCommit.getKey());
                System.out.println(cCommit.getValue());
                
                previousCommit = cCommit.getParent();
        }

        //����������
        public String getRootTreeKey(){
            return this.rootTreeKey;
        }

}