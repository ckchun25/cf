package hk.sfc.base.domain.ce;

import java.util.List;

/**
 * Accredited principal of a central entity.
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR14171</TD><TD>11/05/2009</TD><TD>Richard Shiu</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */
public class AccreditedPrincipal extends CentralEntity {

	private static final long serialVersionUID = -6819826987299822799L;

	/** List of accredited activities. */
	private List accRas;

	/** Array list of accredited activities. */
	private List accRaArrayList;

	/**
	 * setter method of accRas
	 * @param accRas
	 */
	public void setAccRas(List accRas) {
		this.accRas = accRas;
	}

	/**
	 * getter method of accRas
	 * @return List
	 */
	public List getAccRas() {
		return accRas;
	}

	/**
	 * setter method of accRaArrayList
	 * @param accRaArrayList
	 */
	public void setAccRaArrayList(List accRaArrayList) {
		this.accRaArrayList = accRaArrayList;
	}

	/**
	 * getter method of accRaArrayList
	 * @return List
	 */
	public List getAccRaArrayList() {
		return accRaArrayList;
	}
}