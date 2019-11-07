package json.TypeReference;


import java.util.List;
import java.util.Map;

/**
 * 预约提交时用到的参数定义
 * Created by dbwangshuang on 2015/8/24.
 */
public class BookSubmitParam<T extends Book> {

    /**
     * 拆单逻辑后预约主档集合(包括待更新的原预约主档和拆单后新增主档)
     */
    private List<T> books;

    private List<? extends BookLocker> lockers;

    private String pid;

    /**
     * 新locker，用于新预约
     *//*
	private BookLocker locker;

	*/
    /**
     * 新预约日历占用情况，目前只有供应商的自动预约用到此参数
     *//*
	private List<GenesisCalendarParam> calendars;


	private List<Locker> lockerList;*/

    private Map<String, String> poNoBookNoMap;

    private boolean sendGateWay = false;

    /////////////////////////////////////////////////////

    public List<T> getBooks() {
        return books;
    }

    public void setBooks(List<T> books) {
        this.books = books;
    }

    public List<? extends BookLocker> getLockers() {
        return lockers;
    }

    public void setLockers(List<? extends BookLocker> lockers) {
        this.lockers = lockers;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Map<String, String> getPoNoBookNoMap() {
        return poNoBookNoMap;
    }

    public void setPoNoBookNoMap(Map<String, String> poNoBookNoMap) {
        this.poNoBookNoMap = poNoBookNoMap;
    }

    public boolean isSendGateWay() {
        return sendGateWay;
    }

    public void setSendGateWay(boolean sendGateWay) {
        this.sendGateWay = sendGateWay;
    }
}
