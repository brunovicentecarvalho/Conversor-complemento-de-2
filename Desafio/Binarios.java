public class Binarios {
    /**
     * Recebe um número binário codificado com complemento de 2, em uma String
     * que contém apenas sequências de 0s e 1s. A quantidade de dígitos é a
     * quantidade de bits do código.
     * 
     * @param cmpl2 O número binário em complemento de 2.
     * @return Número decimal, em forma de String, para ser printado.
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                System.out.println("Numero em complemento de 2 : "+converterComplementoDoisParaDecimal(args[i]));
            }
        } else {
            System.out.println("Necessaria entrada de dados");
        }
    }
    public static String converterComplementoDoisParaDecimal(String cmpl2) {
        String[] separaCmpl = cmpl2.split("");
        int resultado = 0;
        String retorno = "";
        int[] array = new int[separaCmpl.length];
        int multiplicador = 1;
        if (ehMaximo(separaCmpl)) {
            resultado = 1;
            for (int i = 0; i < array.length; i++) {
                resultado *= 2;
            }
            return "- " + (resultado/2);
        }
        if(Integer.parseInt(separaCmpl[0]) == 1){
            array = inverteArray(separaCmpl);
            retorno = "- ";
        } else {
            for (int i = 1; i < array.length; i++) {
                array[i] = Integer.parseInt(separaCmpl[i]);
            }
        }
        for (int i = array.length - 1; i > 0; i--) {
            resultado += defineDecimal(array[i], multiplicador);
            multiplicador *= 2;
        }
        return retorno + resultado;
        
    }

    public static int defineDecimal(int bit, int multiplicador) {
        return bit * multiplicador;
    }

    public static int[] inverteArray(String[] compl2) {
        int[] array = new int[compl2.length];
        int resto = 1;
        for (int i = compl2.length - 1; i >= 0; i--) {
            int a;
            a = Integer.parseInt(compl2[i]);
            if (a == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
            a = resto + array[i];
            if (a == 2 && i != 0) {
                array[i] = 0;
                resto = 1;
            } else if (a == 0) {
                array[i] = 0;
                resto = 0;
            } else {
                array[i] = 1;
                resto = 0;
            }
        }
        return array;
    }

    public static boolean ehMaximo(String[] array) {
        boolean a = false;
        for (int i = 0; i < array.length; i++) {
            int b = Integer.parseInt(array[i]);
            if (b == 1 && i == 0) {
                a = true;
            } else if (b == 1 && i != 0) {
                return false;
            }
        }
        return a;
    }
}