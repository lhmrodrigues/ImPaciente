# ImPaciente
Esse conjunto de projetos faz parte da disciplina de Linguagem de Programação II da Faculdade de Tecnologia Termomecanica.

A Linguagem de Programação utilizada para a disciplina é Java.

SDK: JAVA 11 (utilizando Mavem para gerenciamento de pacotes)

IDE: 
IntelliJ IDEA 2019.3.4 (Community Edition)
Build #IC-193.6911.18, built on March 17, 2020
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o

# Instalação
1. Fazer download do SDK do JavaFX disponível em: https://gluonhq.com/download/javafx-11-0-2-sdk-windows/
2. Salvar em uma pasta do PC.
3. Após clone do repositorio abrir no IntelliJ.
4. Clicar na Aba Mavem e Atualizar Repositório.

<h1 align="center">
    <img alt="Capa" title="#Capa" src="https://github.com/lhmrodrigues/ImPaciente/blob/master/Anota%C3%A7%C3%A3o%202020-06-27%20170735.png" />
</h1>

5.Configurar o Arquivo de Inicialização do Projeto
6.Clicar em "Edit Configurations"

<h1 align="center">
    <img alt="Capa" title="#Capa" src="https://github.com/lhmrodrigues/ImPaciente/blob/master/Anota%C3%A7%C3%A3o%202020-06-27%20171227.png" />
</h1>

7. Configurações:
<ul>
  <li><b>Main class:</b> UI.Main </li>
  <li><b>VM options:</b> --module-path "{caminhoJavaFX_SDK}\lib" --add-modules javafx.controls,javafx.fxml --add-exports=javafx.base/com.sun.javafx.event=ALL-UNNAMED 
 </li>
  <li><b>JRE:</b> Default(11 - SDK of 'ImPaciente1' module)</li>
</ul>

8. Clicar em "Apply"
9. Clicar em "OK"
10. Agora pode dar run no projeto

