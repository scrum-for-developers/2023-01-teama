package de.codecentric.psd.worblehat.web.formdata;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class BookDataFormDataTest {
  @Test
  void shouldReturnTrimmedIsbn() {
    BookDataFormData bookDataFormData = new BookDataFormData();
    bookDataFormData.setIsbn("  1111111111 \n");
    String actualIsbn = bookDataFormData.getIsbn();
    assertThat(actualIsbn, is("1111111111"));
  }
}
