

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDishesDemo {
    static List<Dishes> dishlist=new ArrayList<>();//�˵�����
    static List<AlreadyDishes> adlist =new ArrayList<>();//�ѵ�˵�����
    public static void main(String[] args) {
        Dishes();//���ò˵���ʼ������
        while(true){//whileѭ����֤����������Ժ���򲻽���
            MainMenu();//���˵�
            Scanner in = new Scanner(System.in);//����
            int s = in.nextInt();
            switch (s){
                case 1:{                    //����1����˵�ҳ
                    Menu();
                    while (true){
                        int m =in.nextInt();
                        if(m==0){
                            break;
                        }
                        if (m>dishlist.size()){
                            System.out.println("��������ȷ�ĺ���������");
                            break;
                        }
                        Dishes dish =dishlist.get(m-1);//���ϵ��±��0��ʼ�����Զ�Ӧ��mӦ�ü�һ
                        System.out.println("������һ��"+dish.getDish_name()+",�������������0�������˵�");
                        //��ӵ��ѵ��Ʒ�ļ���
                        adlist.add(new AlreadyDishes(dish.getId(),dish.getDish_name(),dish.getPrice(),1));
                        //��������ظ��Ĳ�Ʒ����������������ܼ�Ǯ���ϳ�һ������¼
                        for (int i = 0; i < adlist.size(); i++) {
                            for (int j = i+1; j < adlist.size() ; j++) {
                                if(adlist.get(i).getId()==adlist.get(j).getId()) {
                                    adlist.get(j).setNum(adlist.get(j).getNum()+adlist.get(i).getNum());
                                    adlist.get(j).setPrice(adlist.get(j).getPrice()*adlist.get(j).getNum());
                                    adlist.remove(i);
                            }
                            }
                        }
                    }
                    break;
                    }

                case 2:                     //����2�����ѵ��Ʒ��չʾ
                    AlreadyDishes();
                    int s1 =in.nextInt();
                    if (s1==0)
                        break;
                case 3:
                    CheckOut();             //����3����
                    return;
                case 4:                     //����4�˳�����
                    return;
                default:
                    System.out.println("��������ȷ�Ĳ�����������");
            }

        }
    }
    //�˵�ʵ����
    public static void Dishes(){
        Dishes dishes =new Dishes(1,"������",8.0);
        dishlist.add(dishes);
        Dishes dishes1 =new Dishes(2,"����",5.0);
        dishlist.add(dishes1);
        Dishes dishes2 =new Dishes(3,"Ƥ��",2.0);
        dishlist.add(dishes2);
        Dishes dishes3 =new Dishes(4,"±����",3.0);
        dishlist.add(dishes3);
        Dishes dishes4 =new Dishes(5,"±����",6.0);
        dishlist.add(dishes4);
        Dishes dishes5 =new Dishes(6,"±����",2.0);
        dishlist.add(dishes5);
    }
    //���˵�
    public static void MainMenu(){
        System.out.println("-------���˵�------");
        System.out.println("�˵�\t\t\t\t--->1");
        System.out.println("�ѵ�˵�\t\t\t--->2");
        System.out.println("����\t\t\t\t--->3");
        System.out.println("�ر�ϵͳ\t\t\t--->4");
        System.out.println();
        System.out.println("-----------------�������Ӧ��Ž��в���:");
    }
    //�˵��б�
    public static void Menu(){
        System.out.println("-------�˵��б�------");
        for (int i = 0; i < dishlist.size(); i++) {
            Dishes dh = dishlist.get(i);
            System.out.println(dh.getId()+"\t"+dh.getDish_name()+"\t"+dh.getPrice());
        }
        System.out.println("-----------------�͹٣��������ŵ��~");
        System.out.println("-----------------����0�򷵻����˵�");
    }
    //�ѵ��Ʒ
    public static void AlreadyDishes(){
        System.out.println("-------�ѵ��Ʒ------");
        for (int i = 0; i < adlist.size(); i++) {
            AlreadyDishes ads =adlist.get(i);
            System.out.println(ads.getId()+"\t"+ads.getDish_name()+"\t"+ads.getPrice()+"\t\t"+ads.getNum());
        }
        System.out.println("-----------------����0�򷵻����˵�");
    //����
    }
    public static void CheckOut(){
        System.out.println("-------����------");
        System.out.println();
        //������ܹ����Ѷ���Ԫ
        double num=0;
        for (int i = 0; i < adlist.size(); i++) {
            AlreadyDishes ads =adlist.get(i);
            num=ads.getPrice()+num;
        }
        System.out.println("�������ˣ�");
        for (AlreadyDishes ad : adlist) {
            System.out.println(ad.getDish_name()+":"+ad.getNum()+"��");
        }
        System.out.println("�ܹ����ѣ�"+num+"Ԫ");
        
    }

}
