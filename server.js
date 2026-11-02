const http = require('http');
const fs = require('fs');
const path = require('path');

const root = path.join(__dirname, 'public');

http.createServer((req, res) => {
  const file = path.join(root, 'index.html');

  fs.readFile(file, (err, data) => {
    if (err) {
      res.writeHead(500);
      return res.end('KING STAR OS Core Error');
    }

    res.writeHead(200, {
      'Content-Type': 'text/html; charset=utf-8'
    });
    res.end(data);
  });
}).listen(3000, '127.0.0.1', () => {
  console.log('KING STAR OS running at http://127.0.0.1:3000');
});
