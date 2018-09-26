package cn.hn.DataStructs;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-26 上午11:47
 * @desc : TODO
 **/
public class Pair <T> {
    private T first;
    private T second;

    public Pair(){

    }

    public Pair (T first,T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
