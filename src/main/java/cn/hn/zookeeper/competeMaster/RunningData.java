package cn.hn.zookeeper.competeMaster;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-12 上午8:42
 **/
import java.io.Serializable;

public class RunningData implements Serializable {
    private static final long serialVersionUID = 4260577459043203630L;


    //服务器id
    private long cid;
    //服务器名称
    private String name;


    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
