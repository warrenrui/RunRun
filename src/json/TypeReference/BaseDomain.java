package json.TypeReference;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有Domain的基类
 *
 * @author wshuang
 */
public abstract class BaseDomain implements Serializable {

    /**
     * 主键
     */
    protected long id;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 创建人
     */
    protected String createUser;

    /**
     * 修改时间
     */
    protected Date updateTime;

    /**
     * 修改人
     */
    protected String updateUser;

    /**
     * 版本号
     */
    private int version;

    /**
     * 删除标识(0:删除 1:正常)
     */
    protected int yn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}