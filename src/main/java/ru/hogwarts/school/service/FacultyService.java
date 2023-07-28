package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.NoSuchElementException;

@Service
public class FacultyService {
    @Autowired
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty crateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(Long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getFacultiesByColor(String color) {
        return facultyRepository.getFaculByColor(color);

    }

    public Collection<Faculty> getFacultiesByNameOrColor(String searchString) {
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(searchString, searchString);
    }


    public Collection<Student> getFacultyStudents(Long facultyId) {
        Faculty faculty = facultyRepository.findFacultyById(facultyId);
        if (faculty == null) {
            throw new NoSuchElementException("Факультет не найден");
        }
        return faculty.getStudents();
    }

}

