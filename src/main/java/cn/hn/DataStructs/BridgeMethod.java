package cn.hn.DataStructs;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-26 下午5:29
 * @desc : TODO
 **/
public class BridgeMethod extends Pair<String>{


    public  void setFirst(String str){

    }


    public static void main(String[] args) {
        Container<String> c = new SubContainer();
        Container<String> d = new Container();
//        SubContainer f = (SubContainer) new Container<String>();
        String s = "teast";
        c.add(s);
        d.add(s);

        System.out.println(s.charAt(2));
    }
}


class Container<T>{
    public void add(T t){
        System.out.println("this is super class!");
    }
}

class SubContainer extends Container<String>{
    public void add(String s){
        System.out.println("this is a extends class!");
    }
}



