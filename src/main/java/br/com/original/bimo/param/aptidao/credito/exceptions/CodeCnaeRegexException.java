package br.com.original.bimo.param.aptidao.credito.exceptions;

public class CodeCnaeRegexException extends RuntimeException {

    public CodeCnaeRegexException(String code) {
        super("Code Cnae Regex Exception : " + code);
    }
}
