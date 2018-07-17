package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private String id;

    private String loginname;

    private String password;

    private Date createtime;

    private BigDecimal bhpx;

    private String flag;
    
    private String ssdw;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public BigDecimal getBhpx() {
        return bhpx;
    }

    public void setBhpx(BigDecimal bhpx) {
        this.bhpx = bhpx;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
    
	/**
	 * @return the ssdw
	 */
	public String getSsdw() {
		return ssdw;
	}

	/**
	 * @param ssdw the ssdw to set
	 */
	public void setSsdw(String ssdw) {
		this.ssdw = ssdw;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", loginname=" + loginname + ", password=" + password + ", createtime=" + createtime
				+ ", bhpx=" + bhpx + ", flag=" + flag + "]";
	}

	/**
	 * @param id
	 * @param loginname
	 * @param password
	 * @param createtime
	 * @param bhpx
	 * @param flag
	 */
	public User(String id, String loginname, String password, Date createtime, BigDecimal bhpx, String flag) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.createtime = createtime;
		this.bhpx = bhpx;
		this.flag = flag;
	}
    
	/**
	 * @param loginname
	 * @param password
	 */
	public User(String loginname, String password) {
		super();
		this.loginname = loginname;
		this.password = password;
	}

	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
}