Algoritmo "Cadastro_Clientes_Top_Trip_Viagens"
// Disciplina   : [Linguagem e Lógica de Programação]
// Professor   : Antonio Carlos Nicolodi

Var
   clientes: vetor[0..2, 0..4] de caracter
   i,j:inteiro
   rotulo: vetor [0..4] de caracter
   cl_pesq:caracter
   opcao:caracter
   achou:logico

procedimento topo ()
inicio
   escreval( "-----------------------------------")
   escrevaL( "CADASTRO CLIENTES TOP TRIP VIAGENS")
   escreval( "-----------------------------------")
fimprocedimento

Inicio


   rotulo[0] <- "Nome: "
   rotulo[1] <- "CPF: "
   rotulo[2] <- "Email: "
   rotulo[3] <- "Cidade origem: "
   rotulo[4] <- "Cidade destino: "

   topo()

   Escreval(" [1] para Cadastrar")
   Escreval (" [2] para Consultar")
   leia(opcao)

   Escolha opcao
   caso "1"

      escreval(" Digite os dados do cliente: ")
      escreval()
      para i de 0 ate 2 faca

         escreval( "Cliente ", i+1)

         para j de 0 ate 4 faca
            escreva (rotulo[j])
            leia (clientes [i,j])

         fimpara
         escreval()
      fimpara
      escreval (" Fim dos dados")
      limpatela
      escreval (" *****DADOS DOS CLIENTES******")
      escreval()
      para i de 0 ate 2 faca
         para j de 0 ate 4 faca
            escreva (rotulo[j])
            escreval( clientes [i,j])
         fimpara

         escreval()
      fimpara

      topo()

      Escreval(" [1] para Cadastrar")
      Escreval (" [2] para Consultar")
      leia(opcao)


   caso "2"
      escreval(" Informe o nome do cliente")
      leia (cl_pesq)
      para i de 1 ate 2 faca
         Se  cl_pesq = clientes [i] ENTAO
            escreval (" Nome do cliente encontrado")
            escreval( " Seu nome é: ", clientes[i,j])
            escreval(" Seu destino: ", destino[j])
            achou:= verdadeiro
         fimse
      fimpara

      Se achou <> verdadeiro   entao
         escreval( " Nome não encontrado")
      fimse
   fimescolha


Fimalgoritmo