package br.com.rodrigoeduque

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {
    val request = FuncionarioRequest.newBuilder()
        .setNome("Yuri Matheus")
        .setCpf("111.111.111-11")
        .setSalario(2000.20)
        .setAtivo(true)
        .setCargo(Cargo.QA)
        .addEnderecos(Endereco.newBuilder()
            .setLogradouro("Rua das Tabajaras")
            .setCep("00000-000")
            .setComplemento("Casa 20")
            .build())
        .build()


    println("--------------------")
    println("Request => $request")

    request.writeTo(FileOutputStream("funcionario-request.bin"))

    val request2 = FuncionarioRequest.newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))
    println("--------------------")
    println("Request2 => $request2")

    request2.setCargo(Cargo.GERENTE)
    println("--------------------")
    println("Request2 Alterado => $request2")

}