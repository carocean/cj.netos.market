package cj.netos.market.model;

/**
 * Table: site
 */
public class Site {
    /**
     * Column: id
     * Remark: 标识
     */
    private String id;

    /**
     * Column: title
     * Remark: 显示标题
     */
    private String title;

    /**
     * Column: source
     * Remark: 电商源
     */
    private String source;

    /**
     * Column: sort
     * Remark: 排序
     */
    private Integer sort;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }
}