# zubair laser website

A ClojureScript React website built with shadow-cljs

## Development

```bash
# Install dependencies
$ npm ci

# Start application and tests
$ npm start

# Run tests in node with jsdom
$ npm test

# Build for production
$ npm run build
```

Development server: `http://localhost:5000`

## Deployment

This project requires **JDK 21+** to build (for shadow-cljs compilation).

### Option 1: Deploy to Render.com (Recommended)

1. Push your code to GitHub/GitLab
2. Connect your repository to [Render.com](https://render.com)
3. Render will automatically detect the `render.yaml` configuration
4. Deploy with one click - Render uses the included Dockerfile with JDK 21

### Option 2: Deploy to Railway.app

1. Push your code to GitHub
2. Connect to [Railway.app](https://railway.app)
3. Railway will use the Dockerfile to build with JDK 21

### Option 3: Build Locally (Works with any static host)

If you want to deploy to Netlify, Vercel, or GitHub Pages:

```bash
# Build on your local machine (requires JDK 21+)
$ npm run build

# The compiled site is in the public/ directory
# Deploy public/ to any static hosting service
```

## Project Structure

- `src/main/` - ClojureScript source files
- `public/` - Static assets and compiled JavaScript output
- `shadow-cljs.edn` - Build configuration
- `Dockerfile` - Docker build with JDK 21 for deployment platforms
