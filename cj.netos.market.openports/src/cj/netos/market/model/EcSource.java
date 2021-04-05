package cj.netos.market.model;

/**
 * Table: ec_source
 */
public class EcSource {
    /**
     * Column: id
     * Remark: 标识
     */
    private String id;

    /**
     * Column: title
     * Remark: 电商来源显示名
     */
    private String title;

    /**
     * Column: state
     * Remark: 0为不可用 1为可用
     */
    private Integer state;

    /**
     * Column: ctime
     */
    private String ctime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }
}