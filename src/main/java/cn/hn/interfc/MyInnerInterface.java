package cn.hn.interfc;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-10 上午10:17
 **/
public class MyInnerInterface {
    private int size=5;
    private int id;

    public interface OnClickListener{
        void onClick(int id);
    }

    public void onClick(OnClickListener obj){
        obj.onClick(this.id);
    }

    public Object makeInner(int localvar){
        final int finallocalvar = localvar;
        return new Object(){
            public String toString(){
                return "OuterSize="+size+"\nfinalLocalvar="+finallocalvar;
            }
        };
    }

    public static void main(String args[]){
        Object obj=new MyInnerInterface().makeInner(67);
        System.out.println(obj.toString());

        MyInnerInterface m = new MyInnerInterface();
        m.onClick(new OnClickListener() {

            public void onClick(int id) {
                System.out.println(id);
            }
        });
    }
}
