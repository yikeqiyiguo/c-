

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderDishesDemo {
    static List<Dishes> dishlist=new ArrayList<>();//菜单集合
    static List<AlreadyDishes> adlist =new ArrayList<>();//已点菜单集合
    public static void main(String[] args) {
        Dishes();//调用菜单初始化函数
        while(true){//while循环保证输入操作数以后程序不结束
            MainMenu();//主菜单
            Scanner in = new Scanner(System.in);//输入
            int s = in.nextInt();
            switch (s){
                case 1:{                    //输入1进入菜单页
                    Menu();
                    while (true){
                        int m =in.nextInt();
                        if(m==0){
                            break;
                        }
                        if (m>dishlist.size()){
                            System.out.println("请输入正确的号数！！！");
                            break;
                        }
                        Dishes dish =dishlist.get(m-1);//集合的下标从0开始，所以对应的m应该减一
                        System.out.println("您点了一个"+dish.getDish_name()+",请继续或者输入0返回主菜单");
                        //添加到已点菜品的集合
                        adlist.add(new AlreadyDishes(dish.getId(),dish.getDish_name(),dish.getPrice(),1));
                        //如果点了重复的菜品，算出其总数量、总价钱，合成一个条记录
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

                case 2:                     //输入2进入已点菜品的展示
                    AlreadyDishes();
                    int s1 =in.nextInt();
                    if (s1==0)
                        break;
                case 3:
                    CheckOut();             //输入3结账
                    return;
                case 4:                     //输入4退出程序
                    return;
                default:
                    System.out.println("请输入正确的操作数！！！");
            }

        }
    }
    //菜单实例化
    public static void Dishes(){
        Dishes dishes =new Dishes(1,"荞凉粉",8.0);
        dishlist.add(dishes);
        Dishes dishes1 =new Dishes(2,"冰粉",5.0);
        dishlist.add(dishes1);
        Dishes dishes2 =new Dishes(3,"皮蛋",2.0);
        dishlist.add(dishes2);
        Dishes dishes3 =new Dishes(4,"卤豆腐",3.0);
        dishlist.add(dishes3);
        Dishes dishes4 =new Dishes(5,"卤鸡腿",6.0);
        dishlist.add(dishes4);
        Dishes dishes5 =new Dishes(6,"卤鸡蛋",2.0);
        dishlist.add(dishes5);
    }
    //主菜单
    public static void MainMenu(){
        System.out.println("-------主菜单------");
        System.out.println("菜单\t\t\t\t--->1");
        System.out.println("已点菜单\t\t\t--->2");
        System.out.println("结账\t\t\t\t--->3");
        System.out.println("关闭系统\t\t\t--->4");
        System.out.println();
        System.out.println("-----------------请输入对应编号进行操作:");
    }
    //菜单列表
    public static void Menu(){
        System.out.println("-------菜单列表------");
        for (int i = 0; i < dishlist.size(); i++) {
            Dishes dh = dishlist.get(i);
            System.out.println(dh.getId()+"\t"+dh.getDish_name()+"\t"+dh.getPrice());
        }
        System.out.println("-----------------客官，请输入编号点菜~");
        System.out.println("-----------------输入0则返回主菜单");
    }
    //已点菜品
    public static void AlreadyDishes(){
        System.out.println("-------已点菜品------");
        for (int i = 0; i < adlist.size(); i++) {
            AlreadyDishes ads =adlist.get(i);
            System.out.println(ads.getId()+"\t"+ads.getDish_name()+"\t"+ads.getPrice()+"\t\t"+ads.getNum());
        }
        System.out.println("-----------------输入0则返回主菜单");
    //结账
    }
    public static void CheckOut(){
        System.out.println("-------结账------");
        System.out.println();
        //计算出总共消费多少元
        double num=0;
        for (int i = 0; i < adlist.size(); i++) {
            AlreadyDishes ads =adlist.get(i);
            num=ads.getPrice()+num;
        }
        System.out.println("您购买了：");
        for (AlreadyDishes ad : adlist) {
            System.out.println(ad.getDish_name()+":"+ad.getNum()+"份");
        }
        System.out.println("总共花费："+num+"元");
        
    }

}
