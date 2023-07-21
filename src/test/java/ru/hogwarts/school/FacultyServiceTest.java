package ru.hogwarts.school;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FacultyServiceTest {
    private FacultyService facultyService;

    @BeforeEach
    void setUp() {
        facultyService = new FacultyService();
    }

    @Test
    void createFacultyTest() {
        Faculty actual = facultyService.crateFaculty(new Faculty(null, "Gryffindor", "Yellow"));
        assertEquals("Gryffindor", actual.getName());
        assertEquals(1, actual.getId());
        assertEquals("Yellow", actual.getColor());
    }

    @Test
    void findFacultyTest() {
        facultyService.crateFaculty(new Faculty(1L, "Slytherin", "Green"));
        facultyService.crateFaculty(new Faculty(2L, "Ravenclaw", "Blue"));
        Faculty found = facultyService.findFaculty(2L);
        assertEquals(2, found.getId());
    }

    @Test
    void editFacultyTest() {
        Faculty createdFaculty = facultyService.crateFaculty(new Faculty(null, "Hufflepuff", "Black"));
        Faculty updatedFaculty = new Faculty(createdFaculty.getId(), "Slytherin", "Green");
        assertEquals("Slytherin", updatedFaculty.getName());
        assertEquals("Green", updatedFaculty.getColor());
        assertEquals(1, facultyService.getAll().size());
    }

    @Test
    void deleteFacultyTest() {
        facultyService.crateFaculty(new Faculty(null, "Ravenclaw", "Blue"));
        facultyService.deleteFaculty(1L);
        assertEquals(0, facultyService.getAll().size());
    }

    @Test
    void getAllFacultiesTest() {
        facultyService.crateFaculty(new Faculty(null, "Gryffindor", "Yellow"));
        facultyService.crateFaculty(new Faculty(null, "Ravenclaw", "Blue"));
        facultyService.crateFaculty(new Faculty(null, "Hufflepuff", "Black"));
        assertEquals(3, facultyService.getAll().size());
    }

    @Test
    void getFacultiesByColor() {
        facultyService.crateFaculty(new Faculty(null, "Gryffindor", "Yellow"));
        facultyService.crateFaculty(new Faculty(null, "Slytherin", "Green"));
        facultyService.crateFaculty(new Faculty(null, "Ravenclaw", "Blue"));
        Collection<Faculty> facultiesByColor = facultyService.getFacultiesByColor("Red");
        assertEquals(0, facultiesByColor.size());
    }

}

