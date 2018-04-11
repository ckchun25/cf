package hk.sfc.base.domain.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * Payment key regeneration Letter Generation Retrieve Address 
 * 
 * <br>
 * <br>&copy; The Securities And Futures Commission of Hong Kong. All rights reserved.
 * <br>Revision History: <br>
 * <TABLE BORDER=1>
 * <TR><TH>ASR</TH><TH>Date</TH><TH>Name</TH><TH>Changes</TH></TR>
 * <TR><TD>ASR15816</TD><TD>03/12/2009</TD><TD>mpkma1</TD><TD>Initial version</TD></TR>
 * </TABLE>
 *
 */

public class Address {

	/** static data members. */
	private static final String ADDRESS_0 = "address_0";
	private static final String ADDRESS_1 = "address_1";
	private static final String ADDRESS_2 = "address_2";
	private static final String ADDRESS_3 = "address_3";
	private static final String ADDRESS_4 = "address_4";
	private static final String ADDRESS_5 = "address_5";
	private static final String ADDRESS_PREFIX = "address_";
	private static final int MAX_NUM_OF_ARRAY = 6;
	/** address0 */
	private String address0;
	/** address1 */
	private String address1;
	/** address2 */
	private String address2;
	/** address3 */
	private String address3;
	/** address4 */
	private String address4;
	/** address5 */
	private String address5;

	/** 
	 * Retrieve address list
	 * @param addrList the address list
	 * @return the address map
	 */
	public static Map<String, String> retrieveAddressList(List<Address> addrList) {
		Map<String, String> _addrParamMap = new HashMap<String, String>();
		Map<String, String> _paramMap = new HashMap<String, String>();
		List<String> _addressArrayList = new ArrayList<String>(MAX_NUM_OF_ARRAY);
		Iterator<Address> _addrListIter = addrList.iterator();

		if (_addrListIter.hasNext()) {
			Address _addrDomain = (Address) _addrListIter.next();

			// Get address from 0 - 5
			_addrParamMap.put(ADDRESS_0, _addrDomain.getAddress0());
			_addrParamMap.put(ADDRESS_1, _addrDomain.getAddress1());
			_addrParamMap.put(ADDRESS_2, _addrDomain.getAddress2());
			_addrParamMap.put(ADDRESS_3, _addrDomain.getAddress3());
			_addrParamMap.put(ADDRESS_4, _addrDomain.getAddress4());
			_addrParamMap.put(ADDRESS_5, _addrDomain.getAddress5());

			// Get existed address, ignore null address
			for (int i = 0; i < _addrParamMap.size(); i++) {
				if (_addrParamMap.get(ADDRESS_PREFIX + i) != null
						&& !("".equals(_addrParamMap.get(ADDRESS_PREFIX + i)))) {
					_addressArrayList.add(_addrParamMap.get(ADDRESS_PREFIX + i));
				}
			}

			// Put address in the right order
			for (int n = 0; n < _addressArrayList.size(); n++) {
				_paramMap.put(ADDRESS_PREFIX + n, _addressArrayList.get(n));
			}
		}// --end-if
		return _paramMap;
	}

	/**
	 * Get address0 of this object.
	 * @return address0
	 */
	public String getAddress0() {
		return address0;
	}

	/**
	 * Set the address0 of this object.
	 * @param address0
	 */
	public void setAddress0(String address0) {
		this.address0 = address0;
	}

	/**
	 * Get address1 of this object.
	 * @return address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Set the address1 of this object.
	 * @param address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Get address2 of this object.
	 * @return address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Set the address2 of this object.
	 * @param address2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Get address3 this object.
	 * @return address3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * Set the address3 of this object.
	 * @param address3
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	/**
	 * Get address4 of this object.
	 * @return address4
	 */
	public String getAddress4() {
		return address4;
	}

	/**
	 * Set the address4 of this object.
	 * @param address4
	 */
	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	/**
	 * Get address5 of this object.
	 * @return address5
	 */
	public String getAddress5() {
		return address5;
	}

	/**
	 * Set the address5 of this object.
	 * @param address5
	 */
	public void setAddress5(String address5) {
		this.address5 = address5;
	}

}
