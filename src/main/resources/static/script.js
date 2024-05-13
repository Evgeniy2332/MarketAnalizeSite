<script>
        let ascending = true; // По умолчанию сортировка по возрастанию

        function sortTable(columnIndex) {
            const table = document.getElementById('bondsTable');
            const tbody = table.querySelector('tbody');
            const rows = Array.from(tbody.querySelectorAll('tr'));

            rows.sort((a, b) => {
                let cellA = a.querySelectorAll('td')[columnIndex].textContent;
                let cellB = b.querySelectorAll('td')[columnIndex].textContent;

                // корректировка если ячейка пустая или NaN
                if (!cellA || isNaN(cellA)) cellA = cellA ? cellA : '';
                if (!cellB || isNaN(cellB)) cellB = cellB ? cellB : '';

                // Выбираем способ сортировки в зависимости от порядка
                return ascending ?
                    cellA.localeCompare(cellB, undefined, { numeric: true }) :
                    cellB.localeCompare(cellA, undefined, { numeric: true });
            });

            // Удаляем существующие строки
            rows.forEach(row => tbody.removeChild(row));

            // Добавляем отсортированные строки обратно в таблицу
            rows.forEach(row => tbody.appendChild(row));

            // Инвертируем порядок сортировки
            ascending = !ascending;
        }
    </script>

    <script>
            // Обработка отправки формы поиска
            document.querySelector('#searchForm').addEventListener('submit', function (event) {
                event.preventDefault(); // Предотвратить отправку формы
                const columnIndex = document.getElementById('columnIndex').value;
                const filterValue = document.getElementById('filterValue').value;

                // Перенаправление на URL с параметрами поиска
                window.location.href = `/resultBonds?columnIndex=${columnIndex}&filterValue=${filterValue}`;
            });
        </script>