public class CHEClass {
	
	int cid;
	int pid;
	String name;
	boolean isAbstract;	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isAbstract() {
		return isAbstract;
	}
	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public CHEClass(int cid, int pid, String name, boolean isAbstract) {
		super();
		this.cid = cid;
		this.pid = pid;
		this.name = name;
		this.isAbstract = isAbstract;
	}
}