package simuladorMemoria;

import java.awt.*;

public class Principal extends InterfaceGrafica {

	public static void main(String[] args)  {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	}
}
