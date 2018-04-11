package hk.sfc.base.dwr;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.directwebremoting.convert.BaseV20Converter;
import org.directwebremoting.dwrp.ProtocolConstants;
import org.directwebremoting.dwrp.SimpleOutboundVariable;
import org.directwebremoting.extend.Converter;
import org.directwebremoting.extend.InboundContext;
import org.directwebremoting.extend.InboundVariable;
import org.directwebremoting.extend.MarshallException;
import org.directwebremoting.extend.OutboundContext;
import org.directwebremoting.extend.OutboundVariable;
import org.directwebremoting.util.LocalUtil;

public class ExtJSDateFormatConvertor extends BaseV20Converter implements Converter {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'\\T'HH:mm:ss");
	@Override
	public Object convertInbound(Class paramType, InboundVariable inVar, InboundContext inCtx) throws MarshallException {
        String _extJSDate = LocalUtil.decode(inVar.getValue());

        // If the text is null then the whole bean is null
        if (_extJSDate.trim().equals(ProtocolConstants.INBOUND_NULL)) {
            return null;
        }

        try {        	
            Date _date = sdf.parse(_extJSDate);
            
            if (paramType == Date.class) {
                return _date;
            } else if (paramType == java.sql.Date.class) {
                return new java.sql.Date(_date.getTime());
            } else if (paramType == Time.class) {
                return new Time(_date.getTime());
            } else if (paramType == Timestamp.class) {
                return new Timestamp(_date.getTime());
            } else if (paramType == Calendar.class) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(_date);
                return cal;
            } else {
                throw new MarshallException(paramType);
            }
        }
        catch (MarshallException ex)
        {
            throw ex;
        }
        catch (Exception ex)
        {
            throw new MarshallException(paramType, ex);
        }
	}

	@Override
	public OutboundVariable convertOutbound(Object data, OutboundContext outCtx) throws MarshallException {
		
		int year, month, day;
		int hour, minute, second;
		
        //long millis;

        if (data instanceof Calendar)
        {
            Calendar cal = (Calendar) data;
            //millis = cal.getTime().getTime();
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);            
            day = cal.get(Calendar.DAY_OF_MONTH);
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute  = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);
        }
        else if (data instanceof Date)
        {
            Date date = (Date) data;
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            //millis = date.getTime();
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);            
            day = cal.get(Calendar.DAY_OF_MONTH);
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute  = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);
        }
        else
        {
            throw new MarshallException(data.getClass());
        }

        return new SimpleOutboundVariable("new Date("+year+","+month +","+day+","+hour+","+minute+","+second+")", outCtx, true);
	}
}
