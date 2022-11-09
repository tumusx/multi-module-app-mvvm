package validateSearch

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.github.tumusx.shared.ValidateSearch
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test

class ValidateSearchTest {
    @get:Rule
    val instantionExecutorRule = InstantTaskExecutorRule()


    @Test
    fun `when search with 5 chars, not return error`() {
        val result = ValidateSearch.onMaxLengthQuery("asdfg")
        assertThat(result).isEmpty()
    }

    @Test
    fun `when empty search, return error`() {
        val result = ValidateSearch.onMaxLengthQuery("")
        assertThat("Não foi possível buscar. É necessário digitar").isEqualTo(result)
    }

    @Test
    fun `when search query more 20 chars, return error`() {
        ValidateSearch.onMaxLengthQuery("sdgçnkjksajpoijaoajpasjfafpfapapjafpjafoqJAS´JKAÁafsjpsojas")
            .apply {
                assertThat("Não foi possível buscar. É necessário digitar até 20 letras.").isEqualTo(
                    this
                )
            }
    }

    @Test
    fun `when search +18, return error`(){
        ValidateSearch.onMaxLengthQuery("+18").apply {
            assertThat("Ops... Esse tipo de pesquisa não é permitido aqui!").isEqualTo(this)
        }
    }
}