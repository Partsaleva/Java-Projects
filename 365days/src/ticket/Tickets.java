package ticket;


import java.util.ArrayList;
import java.util.List;

public class Tickets {

	List<String> tickets=new ArrayList<>();

	public Tickets(List<String> tickets) {
		this.tickets = tickets;
	}

	public List<String> getTickets() {
		return tickets;
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
		Tickets other = (Tickets) obj;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tickets [tickets=" + tickets + "]";
	}
	
	
	
	
}
