SELECT stds.student_id, stds.student_name, sbjs.subject_name, COUNT(exs.student_id) as attended_exams 
FROM Students stds
CROSS JOIN Subjects sbjs
LEFT JOIN Examinations exs ON stds.student_id = exs.student_id and sbjs.subject_name = exs.subject_name
GROUP BY stds.student_id, stds.student_name, sbjs.subject_name
ORDER BY stds.student_id, stds.student_name