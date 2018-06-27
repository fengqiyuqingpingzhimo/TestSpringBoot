package com.example.demo.model;

public class Unit {
    private String guid;

    private String dwmc;

    private String dwbh;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid == null ? null : guid.trim();
    }

    public String getDwmc() {
        return dwmc;
    }

    public void setDwmc(String dwmc) {
        this.dwmc = dwmc == null ? null : dwmc.trim();
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh == null ? null : dwbh.trim();
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Unit [guid=" + guid + ", dwmc=" + dwmc + ", dwbh=" + dwbh + "]";
	}

	/**
	 * @param guid
	 * @param dwmc
	 * @param dwbh
	 */
	public Unit(String guid, String dwmc, String dwbh) {
		super();
		this.guid = guid;
		this.dwmc = dwmc;
		this.dwbh = dwbh;
	}
	

	/**
	 * @param dwmc
	 * @param dwbh
	 */
	public Unit(String dwmc, String dwbh) {
		super();
		this.dwmc = dwmc;
		this.dwbh = dwbh;
	}

	/**
	 * 
	 */
	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}