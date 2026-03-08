# 💰 BudgetWise AI Expense Tracker

A modern, full-stack expense tracking application with AI-powered insights, built with Spring Boot and React.

![BudgetWise](https://img.shields.io/badge/version-1.0.0-blue)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-green)
![React](https://img.shields.io/badge/React-18-61DAFB)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue)

## 🌟 Features

### Core Functionality

- **💳 Transaction Management** - Track income and expenses with detailed categorization
- **📊 Budget Planning** - Set and monitor budgets for different categories
- **🎯 Financial Goals** - Create and track progress towards savings goals
- **📈 Analytics Dashboard** - Visualize spending patterns with interactive charts
- **📤 Data Export** - Export financial data in multiple formats (CSV, JSON, Excel, PDF)

### AI-Powered Features

- **🤖 AI Insights** - Get intelligent spending analysis using Ollama integration
- **💡 Smart Recommendations** - Personalized budget suggestions based on spending patterns
- **📉 Trend Analysis** - AI-driven predictions and spending trend identification

### Social Features

- **👥 Community** - Share financial tips and experiences
- **💬 Comments & Likes** - Engage with community posts
- **📱 Real-time Updates** - Stay connected with the community

### Security & Authentication

- **🔐 JWT Authentication** - Secure token-based authentication
- **👤 User Profiles** - Customizable user profiles with avatars
- **🔒 Password Security** - BCrypt password hashing
- **🛡️ CAPTCHA Protection** - Registration form protection

## 🏗️ Architecture

### Backend (Spring Boot)

```
backend/
├── src/main/java/com/budgetwise/
│   ├── config/          # Configuration classes
│   ├── controller/      # REST API endpoints
│   ├── dto/            # Data Transfer Objects
│   ├── model/          # JPA entities
│   ├── repository/     # Data access layer
│   ├── security/       # Authentication & authorization
│   └── service/        # Business logic
└── src/main/resources/
    ├── application.properties
    └── schema.sql
```

### Frontend (React)

```
frontend/
├── src/
│   ├── api/            # API integration
│   ├── components/     # Reusable components
│   ├── context/        # React Context providers
│   ├── pages/          # Page components
│   └── styles/         # CSS modules
└── public/
```

## 🚀 Getting Started

### ⚠️ Important: First-Time Setup

**Before running the application, you MUST configure your credentials!**

1. **Read the [SETUP.md](SETUP.md) guide** for detailed instructions
2. Copy `backend/src/main/resources/application.properties.example` to `application.properties`
3. Update the file with your database credentials, JWT secret, and email settings

### Prerequisites

- **Java 17** or higher
- **Node.js 16+** and npm
- **PostgreSQL 15+**
- **Groq API Key** (for AI features)
- **Maven** (included via wrapper)

### Database Setup

**See [SETUP.md](SETUP.md) for detailed setup instructions.**

1. Install PostgreSQL and create a database:

```sql
CREATE DATABASE budgetwise;
```

2. Copy and configure `backend/src/main/resources/application.properties`:

```bash
cd backend/src/main/resources
copy application.properties.example application.properties
# Edit application.properties with your credentials
```

### Backend Setup

1. Navigate to the backend directory:

```bash
cd backend
```

2. Run the Spring Boot application:

```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

The backend will start on `http://localhost:8080`

### Frontend Setup

1. Navigate to the frontend directory:

```bash
cd frontend
```

2. Install dependencies:

```bash
npm install
```

3. Start the development server:

```bash
npm start
```

The frontend will start on `http://localhost:3000`

### Groq AI Setup (AI Features)

1. Get your Groq API key from [groq.com](https://groq.com)

2. Add your API key to the `.env` file:

```bash
GROQ_API_KEY=your_groq_api_key_here
```

3. The Groq AI service will be automatically used by the application

## 📦 Building for Production

### Backend

```bash
cd backend
.\mvnw.cmd clean package
java -jar target/budgetwise-backend-1.0.0.jar
```

### Frontend

```bash
cd frontend
npm run build
```

The optimized build will be in the `frontend/build` directory.

## 🔑 API Endpoints

### Authentication

- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `GET /api/auth/profile` - Get user profile

### Transactions

- `GET /api/transactions` - Get all transactions
- `POST /api/transactions` - Create transaction
- `PUT /api/transactions/{id}` - Update transaction
- `DELETE /api/transactions/{id}` - Delete transaction

### Budgets

- `GET /api/budgets` - Get all budgets
- `POST /api/budgets` - Create budget
- `PUT /api/budgets/{id}` - Update budget
- `DELETE /api/budgets/{id}` - Delete budget

### Goals

- `GET /api/goals` - Get all goals
- `POST /api/goals` - Create goal
- `PUT /api/goals/{id}` - Update goal
- `DELETE /api/goals/{id}` - Delete goal

### AI Insights

- `POST /api/ai/insights` - Get AI-powered spending insights

### Export

- `GET /api/export/csv` - Export transactions as CSV
- `GET /api/export/json` - Export transactions as JSON
- `GET /api/export/excel` - Export transactions as Excel
- `GET /api/export/pdf` - Export transactions as PDF

## 🛠️ Technology Stack

### Backend

- **Spring Boot 3.1.5** - Application framework
- **Spring Security** - Authentication & authorization
- **Spring Data JPA** - Database access
- **PostgreSQL** - Relational database
- **JWT** - Token-based authentication
- **Lombok** - Boilerplate code reduction
- **Apache POI** - Excel export
- **iText** - PDF generation

### Frontend

- **React 18** - UI library
- **React Router** - Client-side routing
- **Axios** - HTTP client
- **Context API** - State management
- **CSS3** - Modern styling with animations

## 🎨 UI Features

- **Modern Dark Theme** - Sleek dark gradient design
- **Glassmorphism Effects** - Beautiful backdrop blur effects
- **Responsive Design** - Mobile-first approach
- **Animated Backgrounds** - Dynamic blob animations
- **Smooth Transitions** - Enhanced user experience

## 📊 Database Schema

### Main Tables

- `users` - User accounts
- `transactions` - Financial transactions
- `budgets` - Budget plans
- `goals` - Savings goals
- `posts` - Community posts
- `comments` - Post comments
- `likes` - Post likes
- `settings` - User preferences

## 🔒 Security Features

- JWT token-based authentication
- BCrypt password hashing
- CORS configuration
- SQL injection prevention
- XSS protection
- CAPTCHA for registration
- **Environment-based configuration** - sensitive data kept out of source control

## 🌐 Environment Variables

**Important:** Never commit `application.properties` with real credentials!

Use the provided `application.properties.example` as a template.

See [SETUP.md](SETUP.md) for detailed configuration instructions.

## 📝 License

This project is licensed under the MIT License.

## 👥 Contributors

- **VinuHashini1711** - Project Owner

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📞 Support

For support, please open an issue in the GitHub repository.

## 🗺️ Roadmap

- [ ] Mobile application (React Native)
- [ ] Bill reminders and notifications
- [ ] Multi-currency support
- [ ] Bank account integration
- [ ] Receipt scanning with OCR
- [ ] Advanced analytics and reporting
- [ ] Budgeting templates
- [ ] Family/group budgeting

## 📸 Screenshots

### Login Page

Modern authentication with glassmorphic design and animated background.

### Dashboard

Comprehensive overview of financial health with charts and statistics.

### Transactions

Easy-to-use transaction management with filtering and categorization.

### AI Insights

Intelligent spending analysis powered by Ollama AI.

---

**Made with ❤️ by VinuHashini1711**
