package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher();
        publisher1.setName("Dumbledore publishing");

        Author author1 = new Author("Rowling", "J. K.");

        Book book1 = new Book("Sorcerer's Stone", "123");
        Book book2 = new Book("Chamber of Secrets", "456");
        Book book3 = new Book("Prizoner of Azkaban", "789");

        book1.setPublisher(publisher1);
        book2.setPublisher(publisher1);
        book3.setPublisher(publisher1);

        author1.getBooks().add(book1);
        author1.getBooks().add(book2);
        author1.getBooks().add(book3);

        book1.getAuthors().add(author1);
        book2.getAuthors().add(author1);
        book3.getAuthors().add(author1);

        publisherRepository.save(publisher1);
        authorRepository.save(author1);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        System.out.println("Started in bootstrap");
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
    }
}
