 //�ع���

/*
 #�ع�����Ҫ��

������һ��commit���ָ���Ӧ�ļ��в��滻ԭ�ȹ������ĸ�Ŀ¼��
    �����鿴��ǰ��֧��commit��ʷ ���ҵ�ĳ����ʷcommit��Ӧ�ĸ�Ŀ¼Tree���󣬻ָ���һ���ļ��У�
        *Commit value�������ǰһ��commit��key�������������
        *��Ŀ¼tree�ָ����ļ��к󣬿���ֱ���滻ԭ�ȹ������ĸ�Ŀ¼��

 +����commit key��ѯ�õ�commit��value��
 +��commit value�н����õ���Ŀ¼tree��key
 +�ָ�(path)��
    ����tree��key��ѯ�õ�value
    ����value�е�ÿһ����¼�������tree������������ļ����ڵ����ļ������ļ��������Լ���Ӧ��blob/tree key
        -����blob����path�д����ļ�������Ϊ��Ӧ���ļ�����д��blob��value
        -����tree����path�д����ļ��У�����Ϊ��Ӧ���ļ��������ݹ���ûָ�(path+�ļ�����)
 +����HEADָ��
*/


/*
 #�ع�-RollBack����ƣ�

public class RollBack{
    ������
    Private Tree rootDirTree;
    private String rootDirTreeKey;
    ����

    ������
    
    ���췽����String theGivenCommitKey,String theGivenPath��{
        ����commit��Ӧ��Ŀ¼tree��key��
        ��ԭ��Ŀ¼Tree��Ӧ���ļ��У�
        ����HEADָ�룻
    }


    ����commit��Ӧ��Ŀ¼tree��key��String theGivenCommitKey��{
        ����commit key��ѯ�õ�commit��value��//����Commit�෽����
        ��commit value�н����õ���Ŀ¼tree��key;
        ���ظ�Ŀ¼tree��key;
    }

    ��ԭ��Ŀ¼Tree��Ӧ���ļ��У�String rootDirTreeKey��throws IOException{
        ����tree��key��ѯ�õ�value;//����Tree�෽����
        ����value,��ȡ���ļ������ļ������ơ���Ӧ��blob/tree key��
        -����blob����theGivenpath�д����ļ���
            ����Ϊ��Ӧ���ļ�����д��blob��value��//����Blob�๹�췽��
        -����tree����theGivenpath�д����ļ��У�
            ����Ϊ��Ӧ���ļ��������ݹ���ûָ�(path+�ļ�����)//����Tree�๹�췽��
    }
}
*/

/*
������
    1.Commit�����ݻع�����Ҫ����������������������Ƿ�ֲ�Head�ࣻ
    2.���ǵ�Ӧ�ã��Ƿ��б�Ҫ���������г������룿
*/