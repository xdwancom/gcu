package SchoolHomework;

import java.util.ArrayList;
import java.util.Scanner;

/*
* （1）SchoolSystem (Integer big, Integer medium, Integer small) 初始化 SchoolSystem类，三个参数分别对应每种班级的剩余名额。
（2）bool addStudent(Integer stuType) 检查是否有 stuType对应的班级。 stuType有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。一个学生只能在stuType对应的班级中。
* 如果没有剩余多的班级人数，请返回 false ，否则将该学生录入班级并返回true。
（3）String[] parse(String input) 解析输入字符串（格式见示例）,返回字符串数组
（4）void print() 输出结果（格式见示例）
【示例】
输入：
["SchoolSystem", "addStudent", "addStudent", "addStudent", "addStudent"]
[[1, 1, 0], [1], [2], [3], [1]]
输出：
[null, true, true, false, false]
【解释】：
SchoolSystem schoolSystem = new SchoolSystem (1, 1, 0); // 初始化有1个大班名额，1个中班名额，0个小班名额
schoolSystem. addStudent (1); // 返回 true ，因为有 1 个剩余的大班名额
schoolSystem. addStudent (2); // 返回 true ，因为有 1 个剩余的中班名额
schoolSystem. addStudent (3); // 返回 false ，因为没有剩余的小班名额
schoolSystem. addStudent (1); // 返回 false ，因为没有剩余的大班名额，唯一1个大班名额已经被占据了
【需要实现的接口及代码主体参考】：


/////
/////

*输入：
["SchoolSystem", "addStudent", "addStudent", "addStudent", "addStudent"]
[[1, 1, 0], [1], [2], [3], [1]]
输出：
[null, true, true, false, false]

*
* */
//报名入学接口
interface ISignUp {
    // 打印输出结果
    public void print();
    // 检查是否有 stuType对应的班级名额
    // 如果没有剩余名额，请返回 false ，否则学生将报名进入该班级并返回 true
    public boolean addStudent (int stuType);
    // 解析命令行输入的参数（格式），如文档描述
    public static String[] parse() throws Exception
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String str2=sc.nextLine();
        String[] split =str2.split("]");
        return split;
    }
}
interface IParams {
    // 设置大班名额
    public int setBig();
    // 设置中班名额
    public int setMedium();
    // 设置小班名额
    public int setSmall();
    // 设置入学序列，例如 [1 2 2 3] 表示 依次报名入学一名大班学生，中班学生，中班学生，小班学生
    public ArrayList<Integer> setPlanSignUp ();
}
public class SchoolSystem implements ISignUp , IParams{
    Integer Big;
    Integer Medium;
    Integer Small;

    public SchoolSystem(Integer big, Integer medium, Integer small) {
        Big = big;
        Medium = medium;
        Small = small;
    }

    @Override
    public int setBig() {
        return this.Big;
    }

    @Override
    public int setMedium() {
        return this.Medium;
    }

    @Override
    public int setSmall() {
        return this.Small;
    }

    @Override
    public ArrayList<Integer> setPlanSignUp() {
        ArrayList<Integer> arr=new ArrayList<Integer>();

        return arr;
    }

    @Override
    public void print() {
        if ((this.Small.intValue()) > 0 )
        {
            System.out.print(null+" ");
        }
        else if((this.Big.intValue())>0)
        {
            System.out.print(null+" ");
        }
        else if((this.Medium.intValue())>0)
        {
            System.out.print(null+" ");
        }
    }

    @Override
    public boolean addStudent(int stuType) {
        if(Big.intValue()>0 && stuType==1) {
            Big--;
            return true;
        }
        if(Medium.intValue()>0 && stuType==2) {
            Medium--;
            return true;
        }
        if(Small.intValue()>0 && stuType==3) {
            Small--;
            return true;
        }
        else {
                return false;
            }
    }

    public static void main(String[] args) throws Exception {
        String[] params = ISignUp.parse();//SchoolSystem.parse();
        char c1 = params[0].charAt(1);
        char c2 = params[0].charAt(4);
        char c3 = params[0].charAt(7);
        int a = (int) c1 - (int) ('0');
        int b = (int) c2 - (int) ('0');
        int c = (int) c3 - (int) ('0');
        SchoolSystem sc = new SchoolSystem(a, b, c);
        ArrayList<Integer> plan = sc.setPlanSignUp();
        for (int i = 1; i <params.length; i++) {
            char c4=params[i].charAt(3);
            int d=(int)c4 - (int) ('0');
            plan.add(d);
        }
        sc.print();
        for (int i = 0; i < plan.size(); i++) {
            System.out.print(sc.addStudent(plan.get(i))+" ");
        }
    }
}
