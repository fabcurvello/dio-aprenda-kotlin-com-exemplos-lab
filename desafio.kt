// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario ( val nome: String )

data class ConteudoEducacional(var nomeCEduc: String, val duracao: Int = 60)

data class Formacao(val nomeFormacao: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        // Adiciona usuário à lista de inscritos
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} mariculado na formação $nomeFormacao.")
    }

    fun imprimirDetalhes() {
        println("Formação: $nomeFormacao")
        println("Nível: $nivel")
        println("Conteúdos: ")
        conteudos.forEach {
            println("- ${it.nomeCEduc}: ${it.duracao} minutos")
        }
        println("Inscritos:")
        inscritos.forEach {
            println("- ${it.nome}")
        }
    }

}

fun main() {
    //Criação de alguns conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Kotlin Básico", 120)
    val conteudo2 = ConteudoEducacional("Kotlin Intermediário")
    val conteudo3 = ConteudoEducacional("Kotlin Avançado", 100)

    //Criação de uma formação
    val formacaoKotlin = Formacao("Formacao Kotlin", listOf(conteudo1, conteudo2, conteudo3), Nivel.DIFICIL)

    //Criação de usuários
    val usuario1 = Usuario("Ana")
    val usuario2 = Usuario("Pedro")

    // Matrícula de usuários na formação
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    //Exibir detalhes da formação
    formacaoKotlin.imprimirDetalhes()
}
