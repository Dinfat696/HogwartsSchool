package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final Map<Long, Faculty> facultys = new HashMap<>();
    private long lastid = 0;


    public Faculty crateFaculty(Faculty faculty) {
        faculty.setId(++lastid);
        facultys.put(lastid, faculty);
        return faculty;
    }

    public Faculty findFaculty(Long id) {
        return facultys.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        if (facultys.containsKey(faculty.getId())) {
            facultys.put(faculty.getId(), faculty);
            return faculty;

        }
        return null;
    }

    public Faculty deleteFaculty(Long id) {
        return facultys.remove(id);
    }

    public Collection<Faculty> getAll() {
        return facultys.values();
    }

    public Collection<Faculty> getFacultiesByColor(String color) {
        return facultys.values().stream()
                .filter(faculty -> faculty.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
    }
}

