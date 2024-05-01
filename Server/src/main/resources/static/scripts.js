function searchParty() {
    const searchName = document.getElementById('searchName').value;

    fetch(`https://localhost:9000/party/getByName/?name=${searchName}`)
        .then(response => response.json())
        .then(data => {
            const partiesContainer = document.getElementById('partiesContainer');
            partiesContainer.innerHTML = '<h2>Search Results:</h2>';

            data.forEach(party => {
                const partyElement = document.createElement('div');
                partyElement.textContent = `Party ID: ${party.id}, Name: ${party.partyName}`;
                partiesContainer.appendChild(partyElement);
            });

            if (data.length === 0) {
                const noResultsMessage = document.createElement('div');
                noResultsMessage.textContent = 'No parties found.';
                partiesContainer.appendChild(noResultsMessage);
            }
        })
        .catch(error => console.error('Error searching parties:', error));
}