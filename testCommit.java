import java.io.IOException;
import java.util.Scanner;

public class testCommit {
	public static void main(String args[])throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("������Commit��Ŀ¼·����");
        String rootDirPath= input.next();
        System.out.println("��������������");
        String author= input.next();
        System.out.println("�������ύ������");
        String committer= input.next();
        System.out.println("�����뱸ע��Ϣ��");
        String message= input.next();

        Commit testCommit=new Commit(rootDirPath,author,committer,message);
        
        System.out.println("����Commit��ValueΪ��"+testCommit.getValue());
        System.out.println("����Commit��KeyΪ��"+testCommit.getKey());

	}

}