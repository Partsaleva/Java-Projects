package ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketMap {

	Map<String, Boolean> tickets=new HashMap<String, Boolean>();

	public TicketMap(Map<String, Boolean> tickets) {
		this.tickets = tickets;
	}

	public Map<String, Boolean> getTickets() {
		return tickets;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		for(Map.Entry<String, Boolean> entry : tickets.entrySet()){
			sb.append(entry.getKey());
			sb.append(" : ");
			sb.append(entry.getValue());
			sb.append(System.getProperty("line.separator"));
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
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
		TicketMap other = (TicketMap) obj;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}
	
	
	
}
