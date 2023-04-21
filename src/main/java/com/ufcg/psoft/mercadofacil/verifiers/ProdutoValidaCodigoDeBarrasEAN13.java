package com.ufcg.psoft.mercadofacil.verifiers;

public class ProdutoValidaCodigoDeBarrasEAN13 implements ProdutoValidaCodigoDeBarras{
    @Override
    public boolean validaCodigoDeBarras(String codigoDeBarras) {
        boolean result = false;
        if (    codigoDeBarras != null
                && codigoDeBarras.length() == 13
                && codigoDeBarras.substring(0, 3).equals("789")
                && codigoDeBarras.substring(3, 8).equals("91375")
        ) {

            int soma = 0;

            String[] codigo = codigoDeBarras.split("");
            for (int i = 11; i >= 0; i--) {
                int num = Integer.parseInt(codigo[i]);
                soma += ((i % 2) != 0) && i != 0 ? num * 3 : num;
            }

            int digitoVerificador = Integer.parseInt(codigo[12]);

            System.out.println(digitoVerificador + " " + soma);

            result = ((soma + digitoVerificador) % 10 == 0);
        }

        return result;
    }
}
