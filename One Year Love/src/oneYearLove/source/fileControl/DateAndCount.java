package oneYearLove.source.fileControl;

import java.io.Serializable;
import java.util.Calendar;

public class DateAndCount  implements Serializable{

	private static final long serialVersionUID = -6104412375725596330L;

	private int dayNumber;
	private Calendar date;
	
	
	
	public DateAndCount(int dayNumber, Calendar date) {
		this.dayNumber = dayNumber;
		this.date = date;
	}

	
	public Calendar getDate() {
		return date;
	}

	public int getDayNumber() {
		return dayNumber;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + dayNumber;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateAndCount other = (DateAndCount) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (dayNumber != other.dayNumber)
			return false;
		return true;
	}
	
	
}
