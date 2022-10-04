package SECAO15_173_CRIANDO_EXCECOES_PERSONALIZADAS.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private int numeroQuarto;
	private Date checkIn;
	private Date checkOut;

	// esta static para que nao seja criado outro SimpleDateFormat, cada vez que um
	// objeto do tipo
	// Reserva seja criado. Só precisa de apenas um objeto sdf
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(int numeroQuarto, Date checkIn, Date checkOut) {
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long duracao() {

		long diferenca = checkOut.getTime() - checkIn.getTime();// retorna em milisegundos
		// convertendo de milisegundos para dias
		System.out.println(TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS));
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);
	}

	public String atualizaDatas(Date checkIn, Date checkOut) {
		
		Date dataAgora = new Date();
		if (checkIn.before(dataAgora) || checkOut.before(dataAgora)) {
			return "As datas só podem ser a partir de amanhã: ";
		}  if (checkOut.before(checkIn)) {
			return "Erro: Data de saída nao pode ser antes da Data de entrada";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		
		return "Quarto: "
				+ numeroQuarto
				+", check-in: "
				+sdf.format(checkIn)
				+ ", check-out: "
				+sdf.format(checkOut)
				+ ", "
				+duracao() + " noites!";
	}

	// Getter´s e Setter´s
	public int getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

}
