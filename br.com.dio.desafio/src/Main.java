import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = CreateCourse("curso java", "descrição curso java", 8);
        Curso curso2 = CreateCourse("curso js", "descrição curso js", 4);

        Mentoria mentoria = CreateCouching("mentoria de java", "descrição mentoria de java", LocalDate.now());

        Bootcamp bootcamp = CreateBootCamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer",
                Arrays.asList(curso1, curso2), List.of(mentoria));

        Dev devCamila = SimulateStudent("Camila", bootcamp, 2);
        Dev devJoao = SimulateStudent("Joao", bootcamp, 3);
    }

    private static Curso CreateCourse(String name, String description, int durationHours){
        Curso course = new Curso();
        course.setTitulo(name);
        course.setDescricao(description);
        course.setCargaHoraria(durationHours);
        return course;
    }

    private static Mentoria CreateCouching(String name, String description, LocalDate localDate){
        Mentoria couching = new Mentoria();
        couching.setTitulo(name);
        couching.setDescricao(description);
        couching.setData(localDate);
        return couching;
    }

    private static Bootcamp CreateBootCamp(String name, String description, List<Curso> courses, List<Mentoria> couchings){
        Bootcamp bootcamp = new Bootcamp();

        bootcamp.setNome(name);
        bootcamp.setDescricao(description);

        for(Curso c: courses){
            bootcamp.getConteudos().add(c);
        }

        for(Mentoria m: couchings){
            bootcamp.getConteudos().add(m);
        }

        return bootcamp;
    }

    private static Dev SimulateStudent(String name, Bootcamp bootcamp, int progress){
        Dev dev = new Dev();
        dev.setNome(name);
        dev.inscreverBootcamp(bootcamp);

        System.out.printf("\n-\nConteúdos Inscritos %s: \n", name);
        for(Conteudo content: dev.getConteudosInscritos()){
            System.out.println(content.getTitulo());
        }

        for(int i = 0; i < progress; i ++){
            dev.progredir();
        }

        System.out.printf("\n-\nConteúdos Concluídos %s: \n", name);
        for(Conteudo content: dev.getConteudosConcluidos()){
            System.out.println(content.getTitulo());
        }
        System.out.println("XP:" + dev.calcularTotalXp());
        System.out.println("-------");
        return dev;
    }
}