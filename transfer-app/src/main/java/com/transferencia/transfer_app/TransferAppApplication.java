package com.transferencia.transfer_app;

/*import com.transferencia.transfer_app.model.Cuenta;
import com.transferencia.transfer_app.repository.CuentaRepository;
import com.transferencia.transfer_app.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;*/

@SpringBootApplication
public class TransferAppApplication /*implements CommandLineRunner*/ {

	/*@Autowired
	private TransferenciaService transferenciaService;

	@Autowired
	private CuentaRepository cuentaRepository;*/

	public static void main(String[] args) {
		SpringApplication.run(TransferAppApplication.class, args);
	}

	/*@Override
	public void run(String... args) {
		ExecutorService executor = Executors.newFixedThreadPool(30); // 30 hilos
		BigDecimal monto = new BigDecimal("5");

		while (true) {
			Cuenta origen = cuentaRepository.findById("abc").orElse(null);
			if (origen == null || origen.getMonto().compareTo(monto) < 0) break;

			executor.submit(() -> transferenciaService.transferir("abc", "cbd", monto));
		}

		executor.shutdown();
		try {
			executor.awaitTermination(2, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Verificamos el resultado final
		Cuenta cuentaA = cuentaRepository.findById("abc").orElse(null);
		Cuenta cuentaB = cuentaRepository.findById("cbd").orElse(null);

		System.out.println("Cuenta abc: $" + (cuentaA != null ? cuentaA.getMonto() : "No encontrada"));
		System.out.println("Cuenta cbd: $" + (cuentaB != null ? cuentaB.getMonto() : "No encontrada"));
	}*/
}
