from flask import Flask, render_template, request, jsonify

app = Flask(__name__)

# Daftar komik yang akan ditampilkan
comics = [
    {"title": "Blue Lock", "chapter": "Chapter 281"},
    {"title": "DANDADAN", "chapter": "Chapter 173"},
    {"title": "One Piece", "chapter": "Chapter 1131"},
    {"title": "Solo Leveling: Ragnarok", "chapter": "Chapter 27"},
]

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/search', methods=['POST'])
def search():
    search_text = request.json.get('searchText', '').lower()
    filtered_comics = [comic for comic in comics if search_text in comic['title'].lower()]
    return jsonify(filtered_comics)

if __name__ == '__main__':
    app.run(debug=True)
