USE cinema;
SELECT
	f1.name as 'Название',
    s1.start_dt as 'Начало',
    f1.duration as 'Длительность',
    f2.name as 'Пересекается с',
    s2.start_dt as 'Начало',
    f2.duration as 'Длительность'
FROM sessions s1
JOIN films f1 ON s1.film = f1.id
JOIN sessions s2 ON s1.id <> s2.id AND s2.start_dt > s1.start_dt AND DATE_ADD(s1.start_dt, INTERVAL f1.duration MINUTE) > s2.start_dt
JOIN films f2 ON s2.film = f2.id
ORDER BY s1.start_dt;

SELECT
	MAX(f1.name) as "Название первого фильма",
	s1.start_dt as "Начало",
    f1.duration as "Длительность",
    MIN(s2.start_dt) as "Начало следующего фильма",
    TIMESTAMPDIFF(MINUTE, DATE_ADD(s1.start_dt, INTERVAL f1.duration MINUTE), MIN(s2.start_dt)) as "Перерыв минут"
FROM sessions s1
JOIN films f1 ON s1.film = f1.id
JOIN sessions s2 ON s1.id <> s2.id AND s2.start_dt > s1.start_dt
GROUP BY s1.start_dt, s1.id, f1.duration
HAVING TIMESTAMPDIFF(MINUTE, DATE_ADD(s1.start_dt, INTERVAL f1.duration MINUTE), MIN(s2.start_dt)) >= 30;
