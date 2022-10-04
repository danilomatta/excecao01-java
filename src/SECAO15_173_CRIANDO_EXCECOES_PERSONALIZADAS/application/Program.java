package SECAO15_173_CRIANDO_EXCECOES_PERSONALIZADAS.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import SECAO15_173_CRIANDO_EXCECOES_PERSONALIZADAS.model.entities.Reserva;
import SECAO15_173_CRIANDO_EXCECOES_PERSONALIZADAS.model.exception.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Numero do Quarto: ");
			int numeroQuarto = scan.nextInt();
			System.out.print("Data de entrada (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.print("Data de saida (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(scan.next());
	
			Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
			System.out.println(reserva);
	
			System.out.println("Entre com as datas para atualizações: ");
			System.out.print("Check-in: ");
			checkIn = sdf.parse(scan.next());
			System.out.print("Check-out: ");
			checkOut = sdf.parse(scan.next());
	
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println(reserva);
		}
		catch (ParseException e) {
			System.out.println("Data no formato inválido");
		}
		
		catch (DomainException e) {
			System.out.println(e.getMessage()); //o .getMessage, pega a mensagem que está 
			//no método alualizaDatas, dentro da classe Reserva, a depender do if
		}
		catch (InputMismatchException e) {
			System.out.println("Numero de quarto não pode ser caractere ou numero decimal");
		}
		scan.close();
	}

}
