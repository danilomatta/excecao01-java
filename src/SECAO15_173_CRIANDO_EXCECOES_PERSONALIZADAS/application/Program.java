package SECAO15_173_CRIANDO_EXCECOES_PERSONALIZADAS.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import SECAO15_173_CRIANDO_EXCECOES_PERSONALIZADAS.model.entities.Reserva;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Numero do Quarto: ");
		int numeroQuarto = scan.nextInt();
		System.out.print("Data de entrada (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.print("Data de saida (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(scan.next());

		if ((checkOut.before(checkIn))) {
			System.out.println("Erro: Data de saída nao pode ser antes da Data de entrada");
		} else {
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println(reserva);

			System.out.println("Entre com as datas para atualizações: ");
			System.out.print("Check-in: ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out: ");
			checkOut = sdf.parse(scan.next());

			Date dataAgora = new Date();
			if (checkIn.before(dataAgora) || checkOut.before(dataAgora)) {
				System.out.println("As datas só podem ser a partir de amanhã: ");
			} else if (checkOut.before(checkIn)) {
				System.out.println("Erro: Data de saída nao pode ser antes da Data de entrada");
			} else {

				reserva.atualizaDatas(checkIn, checkOut);
				System.out.println(reserva);
			}
		}
		scan.close();
	}

}
