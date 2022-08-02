package Chapter1.AfterUp;

/**
 * 관객의 소지품을 보관하는 Bag 클래스
 */
public class Bag {

	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public Long hold(Ticket ticket) {
		if (hasInvitation()) {
			setTicket(ticket);
			return 0L;
		} else {
			setTicket(ticket);
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}

	private boolean hasInvitation() {   // 초대장 보유 여부 판단
		return invitation != null;
	}

	public boolean hasTicket() {   // 티켓 소유 여부 판단
		return ticket != null;
	}

	private void setTicket(Ticket ticket) {   // 초대장을 티켓으로 교환
		this.ticket = ticket;
	}

	private void minusAmount(Long amount) {
		this.amount -= amount;
	}

	private void plusAmount(Long amount) {
		this.amount += amount;
	}

	public Bag(long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}

}
