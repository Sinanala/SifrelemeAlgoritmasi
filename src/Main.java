import java.util.Scanner;

public class Main {
	static String sonic = "!\"#$%&'()*+'-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Metin şifreleme 0 ı tuşlayınız ");
		System.out.println("Şifre çözmek için 1 i tuşlayınız");
		String input = scanner.nextLine();

		if (input.equals("0")) {
			System.out.print("Şifrelemek istediğiniz metni giriniz: ");
			String text = scanner.nextLine();
			System.out.println("Şifrelenen metin: " + sifrele(text));
			// System.out.println("Çözülen: "+sifreCoz(sifrele(text)));

		} else if (input.equals("1")) {
			System.out.print("Şifreyi çözmek istediğiniz metni giriniz: ");
			String text = scanner.nextLine();
			System.out.println("Şifrelenen metin: " + sifreCoz(text));

		} else
			System.out.println("Hatalı Tuşlama yaptınız");

	}

	public static String sifrele(String text) {
		char[] textChars = text.toCharArray();

		for (int i = 0; i < textChars.length; i++) {
			int aklimda = sonic.indexOf(textChars[i]);
			aklimda = (aklimda + textChars.length) % sonic.length();
			textChars[i] = sonic.charAt(aklimda);
		}

		return new String(textChars);
	}

	public static String sifreCoz(String text) {

		char[] textChars = text.toCharArray();

		for (int i = 0; i < textChars.length; i++) {
			int aklimda = sonic.indexOf(textChars[i]);
			aklimda -= textChars.length;
			if (aklimda < 0)
				aklimda += sonic.length();

			textChars[i] = sonic.charAt(aklimda);
		}

		return new String(textChars);

	}
}
