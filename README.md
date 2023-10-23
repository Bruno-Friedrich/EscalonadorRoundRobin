# Simulador de um Escalonador de Processos
> Esse é um programa que representa a execução de um escalonador orientado pelo algoritmo de Round Robin. Dessa forma, ele executará 10 processos que podem possuir até 21 instruções.
- **Os 4 tipos de instruções**
  - **COM**: comando qualquer executado pela máquina
  - **Entrada e saída**: representada pela instrução E/S (representando as chamadas ao sistema)
  - **Atribuição** na forma X=<valor> ou Y=<valor>: onde <valor> é um número inteiro e X e Y são registradores de uso geral
  - **SAIDA**: representa chamada com única finalidade de remover o programa da memória, terminando sua execução

## O que conterá cada arquivo?
- **Arquivo de Processo (.txt)**
  - A primeira linha conterá o nome do processo, as próximas 21 linhas ou menos, terão 4 tipos de instruções já citadas 
- **Arquivo de Quantum (.txt)**
  - Esse arquivo possuirá apenas um número inteiro que representa quantas instruções serão executadas por quantum. Na realidade, esse número é um tempo, mas para efeitos de facilidade, optamos por manter o número de instruções/quantum

## O que a saída gera?
> A saída vai gerar um arquivo logXX.txt (XX representa o valor do quantum) dentro da pasta logs. Nesse log, conterá informações como a inicialização de cada processo, quando um processo vai para a fila de bloqueados (operação de E/S e fica 2 ciclos nela) e quando termina a execução.
>
> Por fim, mostra informações como a média de trocas e quantas instruções foram executadas por quantum.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você instalou a versão mais recente do `java e bibliotecas`
* Compatível com `Windows e Linux`

## 🚀 Instalando o EscalonadorRoundRobin

Para instalar o EscalonadorRoundRobin, siga estas etapas:

- Clone o repositório
  - Pode ser feito da seguinte forma: 
```
git clone <link_do_repositório>
```

## ☕ Usando EscalonadorRoundRobin

Para usar EscalonadorRoundRobin, siga estas etapas:

- Compile o código
```
javac *.java
```

- Para executar:
```
java Escalonador <nome_do_primeiro_processo>.txt <nome_do_segundo_processo>.txt ... <nome_do_décimo_processo>.txt quantum.txt
```
<b></b>
 
Um exemplo de processos que foi deixado no repositório pode ser executado da seguinte forma:
```
javac *.java
java Escalonador 01.txt 02.txt 03.txt 04.txt 05.txt 06.txt 07.txt 08.txt 09.txt 10.txt quantum.txt
```

## 🤝 Colaboradores

A(s) pessoa(s) que contribuiu para o projeto

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/81971651?s=400&u=548b7cc3deb1bd124ba02dbc2acc865b97138ce3&v=4" width="100px;" alt="Foto do Bruno Friedrich no Github"/><br>
        <sub>
          <b>Bruno Friedrich</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

## 😄 O que fazer caso eu queira ser um contribuidor?

Quer fazer parte desse projeto? Sinta-se a vontade para clonar o repositório e editar da forma que preferir :)
