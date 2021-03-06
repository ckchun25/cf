package hk.sfc.base.domain.template;

import hk.sfc.base.domain.SfcDomainObject;

/**
 * 
 * Email Template Object: Table related: lp_t_template
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>06/04/2009</TD><TD>ssyli1</TD><TD>Initial version</TD></TR>
 * <TR><TD>ASR15816</TD><TD>07/12/2009</TD><TD>Suyee Li</TD><TD>Add LPMSGPG002E</TD></TR>
 * </TABLE>
 *
 */
public class Template extends SfcDomainObject {

	private static final long serialVersionUID = -8919108680761465141L;

	/*
	 * Template name static constant can be generated by the following SQL.
		select 'public static final String ' || 
			tmpl_name || ' = "' || tmpl_name || '";' from lp_t_templates 
		order by tmpl_name
	 */
	public static final String LPEMLGR001E = "LPEMLGR001E";
	public static final String LPEMLGR002E = "LPEMLGR002E";
	public static final String LPEMLGR003E = "LPEMLGR003E";
	public static final String LPEMLUR001E = "LPEMLUR001E";
	public static final String LPEMLUR002E = "LPEMLUR002E";
	public static final String LPEMLUR003E = "LPEMLUR003E";
	public static final String LPEMLUR004E = "LPEMLUR004E";
	public static final String LPFRMAR001E = "LPFRMAR001E";
	public static final String LPFRMNT001E = "LPFRMNT001E";
	public static final String LPMSGAR001E = "LPMSGAR001E";
	public static final String LPMSGAR002E = "LPMSGAR002E";
	public static final String LPMSGAR003E = "LPMSGAR003E";
	public static final String LPMSGAR004E = "LPMSGAR004E";
	public static final String LPMSGAR005E = "LPMSGAR005E";
	public static final String LPMSGAR006E = "LPMSGAR006E";
	public static final String LPMSGAR007E = "LPMSGAR007E";
	public static final String LPMSGAR008E = "LPMSGAR008E";
	public static final String LPMSGAR009E = "LPMSGAR009E";
	public static final String LPMSGAR010E = "LPMSGAR010E";
	public static final String LPMSGAR011E = "LPMSGAR011E";
	public static final String LPMSGNT001E = "LPMSGNT001E";
	public static final String LPMSGNT002E = "LPMSGNT002E";
	public static final String LPMSGUR001E = "LPMSGUR001E";
	public static final String LPRPTGR001E = "LPRPTGR001E";
	public static final String LPRPTGR002E = "LPRPTGR002E";
	public static final String LPRPTGR003E = "LPRPTGR003E";
	
	/** For Payment Group Invitation from Billing Entity */
	/** Template for Group member*/
	public static final String LPMSGPG001E = "LPMSGPG001E";
	public static final String LPEMLPG001E = "LPEMLPG001E";
	/** Template for Group payer*/
	public static final String LPMSGPG001BE = "LPMSGPG001BE";
	public static final String LPEMLPG001BE = "LPEMLPG001BE";
		
	public static final String LPMSGPG002E = "LPMSGPG002E";
	public static final String LPEMLPG002E = "LPEMLPG002E";
	public static final String LPMSGPG003E = "LPMSGPG003E";
	public static final String LPEMLPG003E = "LPEMLPG003E";/** Upon deletion of a Member Firm by a Group Payer */
	public static final String LPEMLPG004E = "LPEMLPG004E";
	public static final String LPMSGPG004E = "LPMSGPG004E";
	/** Upon withdrawal from a Payment Group by a Member Firm */
	public static final String LPEMLPG005E = "LPEMLPG005E";
	public static final String LPMSGPG005E = "LPMSGPG005E";
	/** Upon disband of a Payment Group by its Group Payer */
	public static final String LPEMLPG006E = "LPEMLPG006E";
	public static final String LPMSGPG006E = "LPMSGPG006E";
	/** Upon generation of a AF screen 41*/
	public static final String LPMSGPG007E = "LPMSGPG007E";
	public static final String LPEMLPG007E = "LPEMLPG007E";
	/** Upon generation of 1st surcharge screen 114*/
	public static final String LPMSGPG008E = "LPMSGPG008E";
	public static final String LPEMLPG008E = "LPEMLPG008E";
	/** Upon generation of 2nd surcharge screen 115*/
	public static final String LPMSGPG009E = "LPMSGPG009E";
	public static final String LPEMLPG009E = "LPEMLPG009E";
	/** Upon generation of the 3rd surcharge screen 116*/
	public static final String LPMSGPG010E = "LPMSGPG010E";
	public static final String LPEMLPG010E = "LPEMLPG010E";
	/** Upon generation of Invoice screen 122*/
	public static final String LPMSGPG011E = "LPMSGPG011E";
	public static final String LPEMLPG011E = "LPEMLPG011E";
	public static final String LPMSGPG012E = "LPMSGPG012E";
	public static final String LPEMLPG012E = "LPEMLPG012E";
	/** Recurring every 5 calendar days after the creation of a Invoice unless and until screen 124*/
	public static final String LPMSGPG013E = "LPMSGPG013E";
	public static final String LPEMLPG013E = "LPEMLPG013E";
	/** Upon formation of a Payment Group by the Group Payer */
	public static final String LPMSGPG014E = "LPMSGPG014E";
	public static final String LPEMLPG014E = "LPEMLPG014E";
	public static final String LPMSGPG015E = "LPMSGPG015E";
	public static final String LPEMLPG015E = "LPEMLPG015E";
	public static final String LPMSGPG016E = "LPMSGPG016E";
	public static final String LPEMLPG016E = "LPEMLPG016E";
	public static final String LPMSGPG017E = "LPMSGPG017E";
	public static final String LPEMLPG017E = "LPEMLPG017E";
	public static final String LPMSGPG018E = "LPMSGPG018E";
	public static final String LPEMLPG018E = "LPEMLPG018E";
	public static final String LPEMLPG019E = "LPEMLPG019E";
	public static final String LPMSGPG019E = "LPMSGPG019E";
	public static final String LPMSGPG020E = "LPMSGPG020E";
	public static final String LPEMLPG020E = "LPEMLPG020E";
	public static final String LPMSGPG021E = "LPMSGPG021E";
	public static final String LPEMLPG021E = "LPEMLPG021E";
	public static final String LPMSGPG022E = "LPMSGPG022E";
	public static final String LPEMLPG022E = "LPEMLPG022E";
	/** 7 days before due date of AF and AF has not been settled screen 306 */
	public static final String LPMSGPG023E = "LPMSGPG023E";
	public static final String LPEMLPG023E = "LPEMLPG023E";
	/** 7 days before due date of 1st Surcharge and 1st Surcharge has not been settled screen 307 */
	public static final String LPMSGPG024E = "LPMSGPG024E";
	public static final String LPEMLPG024E = "LPEMLPG024E";
	/** 7 days before due date of 2nd  Surcharge and 2nd Surcharge has not been settled screen 308 */
	public static final String LPMSGPG025E = "LPMSGPG025E";
	public static final String LPEMLPG025E = "LPEMLPG025E";
	/** 7 days before due date of 3rd  Surcharge and 3rd Surcharge has not been settled screen 309 */
	public static final String LPMSGPG026E = "LPMSGPG026E";
	public static final String LPEMLPG026E = "LPEMLPG026E";

	/**Template ID*/
	private Long tmplID;

	/** Template Name */
	private String tmplName;

	/**Template Version*/
	private Long version;

	/**Template Usage*/
	private String usage;

	/** Template Type*/
	private String type;

	/** Template Lang */
	private String lang;

	/** Template title */
	private String title;

	/**Template Content*/
	private String content;

	
	/**
	 * @return the tmplID
	 */
	public Long getTmplID() {
		return tmplID;
	}

	
	/**
	 * @param tmplID the tmplID to set
	 */
	public void setTmplID(Long tmplID) {
		this.tmplID = tmplID;
	}

	
	/**
	 * @return the tmplName
	 */
	public String getTmplName() {
		return tmplName;
	}

	
	/**
	 * @param tmplName the tmplName to set
	 */
	public void setTmplName(String tmplName) {
		this.tmplName = tmplName;
	}

	
	/**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}

	
	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	
	/**
	 * @return the usage
	 */
	public String getUsage() {
		return usage;
	}

	
	/**
	 * @param usage the usage to set
	 */
	public void setUsage(String usage) {
		this.usage = usage;
	}

	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	
	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	
	/**
	 * @param lang the lang to set
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	
}