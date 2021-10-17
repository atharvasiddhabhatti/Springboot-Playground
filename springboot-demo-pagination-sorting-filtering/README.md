# Spring Boot - Pagination and Sorting 
Pagination is often helpful when we have a large dataset and we want to present it to the user in smaller chunks.
Also, we often need to sort that data by some criteria while paging.


## Installation
1) Clone the Repo & run the following commands.

## Output
Open in Browser


Access H2 Database.

```
http://localhost:8080/h2-console
```

## Output

| Endpoint | Method | Body | Description |
|:---:|:---:|:---:|:---:|
| http://localhost:8080/student/search | GET | - | To get all students in paginated format |
| http://localhost:8080/student | POST | { "id":214214,"name":"Atharva","rollno":32 } | To Add Students to the DB |
| http://localhost:8080/pagination?pageSize=5 | GET | - | to get first 5 student details |
| http://localhost:8080/pagination?pageSize=5&pageNo=1 | GET | - | To get student details by pagesize 5 and pageno 2 |
| http://localhost:8080/pagination?pageSize=5&pageNo=2 | GET | - | To get student details by pagesize 5 and pageno 1 |
| http://localhost:8080/pagination?pageSize=5&pageNo=1&sortBy=id | GET | - | To sort student details by id |
| http://localhost:8080/pagination?pageSize=5&pageNo=1&sortBy=name | GET | - | To sort student by name |


## Usage
### SortingRepository.java
```java
@Repository
public interface SortingRepository extends PagingAndSortingRepository<Student, Integer>  {

}
```
### StudentService.java
```java
public PaginatedStudentResponse readStudent(Pageable pageable) {
		Page<Student> students = studentRepository.findAll(pageable);
		return PaginatedStudentResponse.builder()
				.numberOfItems(students.getTotalElements()).numberOfPages(students.getTotalPages())
				.studentList(students.getContent())
				.build();
				
	}
	
	public List<Student> getAllStudents(Integer pageNo, Integer pageSize, String sortBy)
		{
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<Student> pageResult = studentRepository.findAll(paging);
			
			if(pageResult.hasContent()) {
				return pageResult.getContent();
			}
			else
			{
				return new ArrayList<Student>();
			}
		}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
```
### PaginationController.java
```java

	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize,
			@RequestParam(defaultValue = "id") String sortBy)
	{
		List<Student> list = service.getAllStudents(pageNo, pageSize, sortBy);
		
		return new ResponseEntity<List<Student>>(list, new HttpHeaders(),HttpStatus.OK);
	}
```
### StudentController.java
```java
@Autowired
	private StudentService studentService;

	@GetMapping("/student/search")
	public ResponseEntity<PaginatedStudentResponse> readStudent(Pageable pageable) {
		return ResponseEntity.ok(studentService.readStudent(pageable));
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> createProduct(@RequestBody Student student){
		return ResponseEntity.ok().body(this.studentService.createStudent(student));
	}
```

## Configuration

### application.properties

```c
spring.jpa.show-sql = true

# Enabling H2 Console
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.defer-datasource-initialization=true
spring.h2.console.enabled=true

# Enable Web Access
spring.h2.console.settings.web-allow-others=true

```
## Credits
https://howtodoinjava.com